package CodeGeneration.DataFlow.Executions;

import CodeGeneration.DataFlow.Blocks.A_Half;
import CodeGeneration.DataFlow.Blocks.A_plus_B_mult_B;
import CodeGeneration.DataFlow.Network.Nodes.Block;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operation;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.BinaryOperations.UnitWiseOperations._Addition;
import CodeGeneration.DataFlow.Network.Nodes.BlocksAndSignalNodes.Operations.NullaryOperation.Source;
import CodeGeneration.utility.Print;
import Enums.AnsiColor;
import LinearAlgebra.Types.Matrices.MatrixBuilder;

import java.util.LinkedList;

public class mainBack {
    private static Print print = new Print(AnsiColor.YELLOW, "Main");

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        print.say("main()");

        ////////// Block Decelerations //////////

        /// Sources ///
        Source source000 = new Source(new MatrixBuilder()
                .addRow(1, 2)
                .addRow(3, 4));
        Source source001 = new Source(MatrixBuilder.buildConstant(2, 2, 2));

        /// Blocks ///
        Block block000 = new A_plus_B_mult_B();
        A_Half block001 = new A_Half();

        /// Operations ///
        Operation operation000 = new _Addition();

        ////////// Connect the network //////////
        block000.connectTo(operation000, "out", "in1");
        block000.connectTo(operation000, "out", "in2");

        operation000.connectTo(block001, "out", "A");

        ////////// Sources, must be connected as the last part of the network. //////////
        source000.connectTo(block000, "out", "A");
        source001.connectTo(block000, "out", "B");

        ////////// Prints //////////
        print.say("block000: " + block000.getChannel("out").getResult());
        print.say("operation000: " + operation000.getChannel("out").getResult());
        print.say("block001: " + block001.getChannel("out").getResult());

        /// Backpropagation ///
        new LinkedList<>(block001.getInputs()).getFirst().acceptReadyBackpropagationSignal();

        ///////// EOF //////////
        print.say("End of main.");
    }
}