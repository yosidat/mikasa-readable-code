package com.mikasareadablecode.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filepath = getFilepathFromArguments(args);
        String message = readMessageResource(filepath);
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
    public static String readMessageResource(String filepath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader= null;
        String resultText = null;
        try {
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);

            resultText = resultText = bufferedReader.readLine();
        }catch(FileNotFoundException e){
            //TODO: エラーハンドリング
        }catch(IOException e){
            //TODO: エラーハンドリング
        }finally {
            //TODO: ファイルクローズ
            //fileReader.close();
            //bufferedReader.close();
        }
        return resultText;
    }

    /**
     * 結果出力処理
     */
    public static void outputResult(String text){
        System.out.println(text);
    }
}
