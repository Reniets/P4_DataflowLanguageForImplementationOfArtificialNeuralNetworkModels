package CodeGeneration.DataFlow.Executions;

import CodeGeneration.DataFlow.Blocks.A_Half;
import CodeGeneration.DataFlow.Blocks.A_plus_B_mult_B;
import CodeGeneration.DataFlow.Blocks.A_uSub_B;
import CodeGeneration.DataFlow.Network.Nodes.Block;
import CodeGeneration.DataFlow.Network.Nodes.Blocks.AbstractBlock;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operation;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.AbstractOperation;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.MatrixOperations.Multiplication;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.UnitWiseOperations._Addition;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.UnitWiseOperations._Division;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.NullaryOperation.Source;
import CodeGeneration.DataFlow.Network.Nodes.SignalNodes.Channels.ListChannel;
import CodeGeneration.utility.Print;
import Enums.AnsiColor;
import LinearAlgebra.Statics.Matrices;
import LinearAlgebra.Types.Matrices.MatrixBuilder;

public class BlockWrapper extends AbstractBlock {

    private static Print print = new Print(AnsiColor.YELLOW, "BlockWrapper");

    public BlockWrapper() {
        // Channel
        this.addNewInputLabel("in", new ListChannel());
        this.addNewOutputLabel("out", new ListChannel());

        Block block = new A_uSub_B();

        Source source = new Source(Matrices.randomMatrix(2, 2, 1337));

        source.connectTo(block, "out", "A");
        this.connectTo(block, "in", "B");

        block.connectTo(this, "out", "out");

        ///////// EOF //////////
    }

    private void oldBlock() {
        // Blueprint
        ///////// Block Decelerations //////////

        /// Sources ///
        Source source001 = new Source(MatrixBuilder.buildConstant(2, 2, 2));

        /// Blocks ///
        Block block000 = new A_plus_B_mult_B();

        this.connectTo(block000, "in", "A");
        source001.connectTo(block000, "out", "B");

        /// Operations ///
        Operation operation000 = new _Addition();

        ////////// Connect the network //////////
        block000.connectTo(operation000, "out", "in1");
        block000.connectTo(operation000, "out", "in2");

        A_Half block001 = new A_Half();

        operation000.connectTo(block001, "out", "A");

        block001.connectTo(this, "out", "out");
    }

}