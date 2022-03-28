package ch.hslu.ad.Datenstrukturen.Lists.BinaryTree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinaryTreeDemo {

    private static final Logger LOG = LogManager.getLogger(BinaryTreeDemo.class);

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(8);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(11);
        binaryTree.add(10);

        // true
        LOG.debug("Searching for:{} -> {}",10, binaryTree.contains(10));
        LOG.debug("{}",binaryTree.search(10));
        LOG.debug("Searching for:{} -> {}",5, binaryTree.contains(5));
        LOG.debug("{}",binaryTree.search(5));
        LOG.debug("Searching for:{} -> {}",1, binaryTree.contains(1));
        LOG.debug("{}",binaryTree.search(1));

        // false
        LOG.debug("Searching for:{} -> {}",19,binaryTree.contains(19));
        LOG.debug("{}",binaryTree.search(19));
        LOG.debug("Searching for:{} -> {}",25,binaryTree.contains(25));
        LOG.debug("{}",binaryTree.search(25));
        LOG.debug("Searching for:{} -> {}",7,binaryTree.contains(7));
        LOG.debug("{}",binaryTree.search(7));
    }

}
