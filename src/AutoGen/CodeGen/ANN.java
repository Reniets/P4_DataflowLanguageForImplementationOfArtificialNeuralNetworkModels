/* The following code was generated by The Language Compiler 1.0.0 */

package AutoGen.CodeGen;

import CodeGeneration.DataFlow.Network.Nodes.Block;
import CodeGeneration.DataFlow.Network.Nodes.Blocks.AbstractBlock;
import CodeGeneration.DataFlow.Network.Nodes.SignalNodes.Channel;
import CodeGeneration.DataFlow.Network.Nodes.SignalNodes.Channels.ListChannel;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operation;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.NullaryOperation.Source;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.UnaryOperations.UnitWiseOperations._Tanh;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.UnaryOperations.UnitWiseOperations._Sigmoid;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.UnaryOperations.UnitWiseOperations._Relu;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.UnaryOperations.MatrixOperations.Transpose;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.UnitWiseOperations._Multiplication;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.UnitWiseOperations._Division;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.UnitWiseOperations._Subtraction;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.UnitWiseOperations._Addition;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.MatrixOperations.Multiplication;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.MatrixOperations.Multiplication;
import DataStructures.Pair;
import AutoGen.CodeGen.Layer;

public class ANN extends AbstractBlock {

    public ANN() {
        this.blueprint();
    }

    private void blueprint() {
        try {
            this.addNewInputLabel("in", new ListChannel());
            this.addNewOutputLabel("out", new ListChannel());
            Block _Layer_219057462;
            _Layer_219057462 = new Layer();
            Block _Layer_468844499;
            _Layer_468844499 = new Layer();
            Block _Layer_1156076399;
            _Layer_1156076399 = new Layer();
            Block _Layer_467170566;
            _Layer_467170566 = new Layer();
            Block _Layer_2080692533;
            _Layer_2080692533 = new Layer();
            Block _Layer_1125687029;
            _Layer_1125687029 = new Layer();
            Block _Layer_1214355979;
            _Layer_1214355979 = new Layer();
            Block _Layer_2006115232;
            _Layer_2006115232 = new Layer();
            Block _Layer_2115499306;
            _Layer_2115499306 = new Layer();
            Block _Layer_347843468;
            _Layer_347843468 = new Layer();
            _Layer_219057462.receiveGroupConnection(this.getChannel("in"));
            _Layer_468844499.receiveGroupConnection(_Layer_219057462);
            _Layer_1156076399.receiveGroupConnection(_Layer_468844499);
            _Layer_467170566.receiveGroupConnection(_Layer_1156076399);
            _Layer_2080692533.receiveGroupConnection(_Layer_467170566);
            _Layer_1125687029.receiveGroupConnection(_Layer_2080692533);
            _Layer_1214355979.receiveGroupConnection(_Layer_1125687029);
            _Layer_2006115232.receiveGroupConnection(_Layer_1214355979);
            _Layer_2115499306.receiveGroupConnection(_Layer_2006115232);
            _Layer_347843468.receiveGroupConnection(_Layer_2115499306);
            _Layer_347843468.connectTo(this.getChannel("out"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}