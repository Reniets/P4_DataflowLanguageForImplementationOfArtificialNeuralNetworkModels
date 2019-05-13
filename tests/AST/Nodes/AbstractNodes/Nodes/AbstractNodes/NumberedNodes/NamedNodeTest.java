package AST.Nodes.AbstractNodes.Nodes.AbstractNodes.NumberedNodes;

import AST.Nodes.NodeClasses.NamedNodes.AssignNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamedNodeTest {

    // Fields:
    private NamedNode node1;

    @BeforeEach
    void beforeEach() {
        this.node1 = new AssignNode();
    }

    @Test
    void getName() {
        assertEquals("Assign", this.node1.getName());
    }

    @Test
    void toString01() {
        assertTrue(this.node1.toString().endsWith("Assign"));
    }
}