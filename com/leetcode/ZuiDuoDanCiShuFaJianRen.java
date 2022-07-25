package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//2284. 最多单词数的发件人
public class ZuiDuoDanCiShuFaJianRen {
    public String largestWordCount(String[] messages, String[] senders) {
        int len = messages.length;
        HashMap<String,Integer> hm = new HashMap<>(len,0.75f);
        for (int i = 0; i < len; i++) {
            hm.put(senders[i],hm.getOrDefault(senders[i],0)+messages[i].split(" ").length);
        }
        int max=0;
        String senderOfMaxMsg = "";
        for (Map.Entry<String,Integer> a:hm.entrySet()){
            if(a.getValue()>max){
                max = a.getValue();
                senderOfMaxMsg = a.getKey();
            }else if(a.getValue()==max){
                senderOfMaxMsg = senderOfMaxMsg.compareTo(a.getKey())>0?senderOfMaxMsg:a.getKey();
            }
        }
        return senderOfMaxMsg;
    }
}
