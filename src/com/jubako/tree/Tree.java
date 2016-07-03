package com.jubako.tree;

import java.util.List;

public class Tree {

    private TreeData data;
    private List<Tree> children;

    public TreeData getData() {
        return data;
    }

    public void setData(TreeData data) {
        this.data = data;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

}
