package com.mikasareadablecode.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filepath = getFilepathFromArguments(args);
        String[] message = readMessageResource(filepath);
        outputResult(message);
    }

    /**
     * プログラム実行時の引数からユーザーが指定した値を取得（第1引数）
     * @param args プログラム実行時引数
     * return ファイルパス(第一引数)
     */
    public static String getFilepathFromArguments(String[] args){
        return args[0];
    }

    /**
     * メッセージリソースの取得
     * @param filepath ファイルパスの記述
     */
    public static String[] readMessageResource(String filepath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader= null;
        List<String> arrayText = new ArrayList<String>();
        try {
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);

            String readText;
            while ((readText = bufferedReader.readLine()) != null) {
                arrayText.add(readText);
            }
        }catch(FileNotFoundException e){
            //TODO: エラーハンドリング
        }catch(IOException e){
            //TODO: エラーハンドリング
        }finally {
            // ファイルクローズ
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                // クローズに失敗しても何もしない
            }
        }
        return arrayText.toArray(new String[0]);
    }

    /**
     * 結果出力処理
     */
    public static void outputResult(String[] text){
        // 複数行を出力する
        for(int index = 0; index < text.length; index++) {
            System.out.println(text[index]);
        }
    }
}
