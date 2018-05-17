package com.plagiarisma.ver1.until;

import java.io.IOException;
import java.util.HashMap;

import vn.hus.nlp.tokenizer.VietTokenizer;

public class Uniti {
	//Tính tần số của các từ trong 1 văn bản
			public static HashMap<String, Integer> getFrequency(String fileName) throws IOException {
				// Khai báo:
				HashMap<String, Integer> hits = new HashMap<String, Integer>(); // Lưu tần số
				Integer number;
				String str = "";
				// Cắt từ:
				VietTokenizer token = new VietTokenizer();
				String[] sentences = token.tokenize(fileName);
				// Xóa các kí tự thừa
				str =HanglingText(sentences[0]);
				// cắt các từ dựa vào khoảng trắng
				String[] words = str.split("\\s");
				// Duyệt các từ ở mảng
				for (String word : words) {
					// Lấy tần số từ đó trong từ điển
					number = hits.get(word);
					// Nếu chưa có thì add từ đó vào từ điển
					// Gán tần số cho từ đó = 1
					if (number == null) {
						hits.put(word, 1);
					// Nếu có rồi tăng tần số thêm 1
					} else {
						hits.put(word, ++number);
					}
				}	
				return hits;
			}
			//Xóa khoảng trắng thừa, kí tự thừa trước khi cắt các từ trong văn bản
			public static String HanglingText(String str) throws IOException {

				str = str.toLowerCase();
				str = str.replaceAll("[\\s+'{}()|~&%@#!$*-.,=`?:”…;’]", " ");
				str = str.replaceAll("[0123456789\"]", " ");
				str = str.replaceAll("\\\\", " ");
				str = str.replaceAll("“", " ");
				str = str.replaceAll("/", " ");
				//Trong file amthuctest.
				if (str.indexOf(" – ") != 16)
					str = str.replaceAll(" – ", "_");

				while (str.indexOf("  ") != -1)
					str = str.replaceAll("  ", " ");
				str = str.trim();
				return str;
			}
}
