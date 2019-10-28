package com.xiaozhengkeji.blog.tools;

import java.util.HashSet;
import java.util.List;

public class ListTool {
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
