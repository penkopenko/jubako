package com.jubako.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeBuilder<T extends TreeData> {

    public Tree createTree(List<T> flatDatas) {
        T root = flatDatas.stream().filter(f -> TreeData.ROOTPARENT.equals(f.getParent())).findFirst().get();

        Tree tree = new Tree();
        tree.setData(root);
        tree.setChildren(getChildren(flatDatas, root.getId()));

        return tree;
    }

    private List<Tree> getChildren(List<T> flatDatas, String parent) {

        List<T> filteredDatas = flatDatas.stream().filter(f -> parent.equals(f.getParent()))
                .collect(Collectors.toList());
        List<Tree> children = new ArrayList<>();

        filteredDatas.forEach(f -> {
            Tree tree = new Tree();
            tree.setData(f);
            tree.setChildren(getChildren(flatDatas, f.getId()));
            children.add(tree);
        });

        return children;
    }
}
