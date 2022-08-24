package com.newcoder;
import java.util.*;
/**
 * @description: NC121 字符串的排列 dfs + 回溯 + 剪枝
 * @author: sixiermu
 * @time: 2022/8/24 15:01
 */
public class ZiFuChuanDePaiLie {

    public ArrayList<String> ans;
    public ArrayList<String> Permutation (String str) {
        // write code here
        this.ans = new ArrayList<>();
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        dfs(0,chs.length,new StringBuilder(12),chs,new int[chs.length]);
        return ans;

    }

//超时
    public void dfs(int k,int n,StringBuilder sb,char[] chs,int[] cnt){
        if(k==n){
            ans.add(sb.toString());
            return;
        }

        for(int i=0;i<n;i++){
            if(cnt[i] == 1 ){
                continue;
            }
            //遇到重复的就剪枝
            if(i>0 && chs[i] == chs[i-1] && cnt[i-1]==0) continue;
            cnt[i] =1;
            dfs(k+1,n,sb.append(chs[i]),chs,cnt);
            sb.deleteCharAt(sb.length()-1);
            cnt[i] =0;
        }
    }


    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if(str == null || str.length() == 0) return result;
        char[] charStr = str.toCharArray();
        // 使用treeSet来保证结果是按照字典序排列的，不用事先排列
        TreeSet<String> resSet = new TreeSet<String>();
        Permutation(charStr,0,resSet);
        //addAll(Collection<? extends E> c)
        //按指定集合的Iterator返回的顺序将指定集合中
        // 的所有元素追加到此列表的末尾。
        result.addAll(resSet);
        return result;
    }

    public void Permutation(char[] chars,int begin,TreeSet<String> treeSet){
        if(chars==null || chars.length==0 || begin<0 || begin>chars.length-1) { return ; }
        if(begin == chars.length-1){
            // 使用交换，可以节省原来使用的memo记录数据的空间
            treeSet.add(String.valueOf(chars));
        }else{
            for(int i=begin;i<chars.length;i++){
                swap(chars,begin,i);
                // 设定下标从上一次的下一个下标开始，可以减少循环次数
                Permutation(chars,begin+1,treeSet);
                swap(chars,begin,i);
            }
        }
    }

    public void swap(char[] chars,int begin,int i){
        char temp = chars[begin];
        chars[begin] = chars[i];
        chars[i] = temp;
    }
}
