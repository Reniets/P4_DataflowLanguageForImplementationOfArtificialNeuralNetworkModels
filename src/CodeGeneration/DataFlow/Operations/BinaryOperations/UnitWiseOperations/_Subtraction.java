package CodeGeneration.DataFlow.Operations.BinaryOperations.UnitWiseOperations;

import CodeGeneration.DataFlow.Operations.BinaryOperations.BinaryOperation;
import LinearAlgebra.Types.Matrices.Matrix;

public class _Subtraction extends BinaryOperation {
    /**
     * Unit-wise subtraction of matrices
     *
     * @param in1 operand 1
     * @param in2 operand 2
     * @return unit-wise subtraction of matrix in1 and in2
     */
    @Override
    protected Matrix operation(Matrix in1, Matrix in2) {
        return in1.sub(in2);
    }
}
