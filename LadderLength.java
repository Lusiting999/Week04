package com.test.week04;

public class LadderLength {
    public static void main(String[] args) {

    }

    /**
     * 广度优先算法
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 用HashSet重新保存wordList，提高性能
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // 去掉开始字符串，类似判重
        wordSet.remove(beginWord);
        // 创建BFS队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // 存放被访问过的结点
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        // 启动BFS
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < currentWord.length(); j++) {
                    // 记录修改位置，保存下来再恢复
                    char tempChar = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == tempChar) {
                            continue;
                        }
                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);
                        // 存在字符集中，即可加入下一层
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return ++step;
                            }
                            // 判断是否访问过
                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    // 恢复
                    charArray[j] = tempChar;
                }
            }
            if (!queue.isEmpty()) {
                step++;
            }
        }
        return 0;
    }
}
