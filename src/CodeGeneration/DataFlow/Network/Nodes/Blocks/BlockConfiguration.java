package CodeGeneration.DataFlow.Network.Nodes.Blocks;

public class BlockConfiguration {
    private int dataRows;
    private double learningRate;

    public BlockConfiguration(int dataRows, double learningRate) {
        this.dataRows = dataRows;
        this.learningRate = learningRate;
    }

    public int getDataRows() {
        return dataRows;
    }

    public void setDataRows(int dataRows) {
        this.dataRows = dataRows;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }
}
