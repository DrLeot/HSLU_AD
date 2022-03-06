package ch.hslu.ad.Lists.SingleList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {


    @Test
    public void testNodeSimple(){
        Node node = new Node(new Animal("Bert"));
        assertEquals("Bert",node.getElement().toString());
    }

    @Test
    public void testGetNextNull(){
        Node node = new Node(new Animal("Bert"));
        assertNull(node.getNext());
    }

    @Test
    public void testGetNext(){
        Node firstNode = new Node(new Animal("Gisela"));
        Node secondNode = new Node(new Animal("Bert"));
        firstNode.link(secondNode);
        assertEquals(secondNode,firstNode.getNext());
    }

    @Test
    public void testUnlink(){
        Node firstNode = new Node(new Animal("Gisela"));
        Node secondNode = new Node(new Animal("Bert"));
        firstNode.link(secondNode);
        firstNode.link(null);
        assertNull(firstNode.getNext());
    }
}