package CodeGeneration.DataFlow.Operations;

public class Addition extends BinaryOperation {
    @Override
    float operation(float in1, float in2) {
        return in1 + in2;
    }
}
