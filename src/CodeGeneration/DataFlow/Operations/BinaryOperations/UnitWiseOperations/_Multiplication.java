package CodeGeneration.DataFlow.Operations.BinaryOperations.UnitWiseOperations;

import CodeGeneration.DataFlow.Operations.BinaryOperations.BinaryOperation;
import LinearAlgebra.Types.Matrices.Matrix;
import LinearAlgebra.Types.Matrices.MatrixBuilder;

public class _Multiplication extends BinaryOperation {
    @Override
    protected Matrix operation(Matrix in1, Matrix in2) {
        MatrixBuilder out = new MatrixBuilder(in1.getRows(), in1.getColumns(), true);
        return out.multiplicationToEntries(in2).build();
    }
}
