package com.linhongbo.huawei;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * 输入描述:一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * <p>
 * 输出描述:将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 */
public class _19 {

    // 傻逼题目，输出最后8条记录，但是要保存全部记录
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Error> errors = new LinkedList<>();
        while (scanner.hasNext()) {
            format(errors, scanner.next(), scanner.next());
        }
        StringBuilder sb = new StringBuilder("");
        int index = errors.size() > 8 ? 7 : errors.size() - 1;
        for (int i = index; i >= 0; i--) {
            Error error = errors.get(i);
            sb.append(error.fileName).append(" ").append(error.line).append(" ").append(error.count).append("\n");
        }
        System.out.print(sb.toString());
        scanner.close();
    }

    private static void format(LinkedList<Error> errors, String fileName, String lineStr) {
        int line = Integer.parseInt(lineStr);
        if (fileName.contains("\\")) {
            fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        }
        fileName = fileName.length() > 16 ? fileName.substring(fileName.length() - 16) : fileName;
        Error error = new Error(fileName, line);
        if (errors.contains(error)) {
            errors.get(errors.indexOf(error)).count++;
        } else {
            errors.addFirst(error);
        }
    }

    private static class Error {
        private String fileName;
        private int line;
        private int count;

        public Error() {
        }

        public Error(String fileName, int line) {
            this.fileName = fileName;
            this.line = line;
            this.count = 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Error)) return false;
            Error error = (Error) o;
            return line == error.line &&
                    Objects.equals(fileName, error.fileName);
        }
    }

}
