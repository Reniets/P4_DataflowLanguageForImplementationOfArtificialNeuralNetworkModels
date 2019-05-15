package CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations;

import CodeGeneration.DataFlow.Network.Nodes.Blocks.AbstractBlock;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operation;
import CodeGeneration.DataFlow.Network.Nodes.SignalNodes.Channel;
import CodeGeneration.utility.Print;
import Enums.AnsiColor;
import LinearAlgebra.Types.Matrices.Matrix;

import java.util.HashMap;

public abstract class AbstractOperation extends AbstractBlock implements Operation {
    private boolean isReady = false;
    private boolean isReadyBackpropagation = false;
    protected Matrix result;
    protected HashMap<Channel, Matrix> resultBackpropagation = new HashMap<>();

    protected Print forward = new Print(AnsiColor.GREEN, "Channel." + this.getClass().getSimpleName());
    protected Print backprop = new Print(AnsiColor.YELLOW, "Channel." + this.getClass().getSimpleName());

    /**
     * Get result of operation
     *
     * @return result as float
     */
    @Override
    public Matrix getResult() {
        //forward.say("getResult() -> this.result = " + this.result);
        return result;
    }

    /**
     * Given that all inputs of the operation are isReady, perform operation and set outChannel signal to isReady
     */
    @Override
    public void acceptReadySignal() {
        forward.say("I have accepted a ready signal");

        if (this.isReady()) {                       // If all inputs are isReady
            this.isReadyBackpropagation = false;
            forward.say("-> And I was ready");

            this.performOperation();                // Then perform the operation
            this.getOutputChannel().acceptReadySignal();  // And signal that the output channel now is isReady.
        } else {
            forward.say("-> And I was not ready");
        }
    }

    protected abstract Channel getOutputChannel();

    /**
     * Checks if operation is isReady to be performed
     *
     * @return boolean value of whether all operation inputs are isReady, or there are no inputs.
     */
    private boolean isReady() {
        if (this.isReady)
            return true;

        if (this.getInputs().isEmpty())
            return (this.isReady = true);

        for (Channel inputChannel : this.getInputs())
            if (!inputChannel.isReady())
                return false;

        return (this.isReady = true);
    }

    /**
     * Get the output of the given channel
     *
     * @param channelId channel to get output from
     * @return Matrix value from output of channel
     */
    protected Matrix getInputValue(String channelId) {
        return this.getChannel(channelId).getResult();
    }

    @Override
    public void acceptReadyBackpropagationSignal() {
        backprop.say("I accepted a back prop signal");

        if (this.isReadyBackpropagation()) {                       // If all inputs are isReady
            this.isReady = false;
            this.performBackpropagationOperation();                // Then perform the operation

            backprop.say("And I was Ready");

            for (Channel inputChannel : this.getInputs()) {
                backprop.say("Sent to -> " + inputChannel);
                inputChannel.acceptReadyBackpropagationSignal();  // And signal that the output channel now is isReady.
            }
        }

        backprop.say("And I was not Ready");

    }

    @Override
    public boolean isSource() {
        for (Channel input : this.getInputChannels().values()) {
            if (!input.isSource()) {
                return false;
            }
        }

        // Perform the operation, since this node will only update from sources
        this.performOperation();
        // Return true, to signal that data is ready.
        return true;
    }

    @Override
    public boolean isReadyBackpropagation() {
        if (this.isReadyBackpropagation)
            return true;

        if (this.getOutputs().isEmpty())
            return (this.isReadyBackpropagation = true);

        for (Channel outputChannel : this.getOutputs())
            if (!(outputChannel.isReadyBackpropagation()))
                return false;

        return (this.isReadyBackpropagation = true);
    }

    @Override
    public Matrix getResultBackpropagation(Channel channel) {
        if(!this.getInputs().contains(channel)) {
            throw new IllegalArgumentException("Channel is not a part of this operations inputs! >:(");
        }

        return this.resultBackpropagation.get(channel);
    }
}
