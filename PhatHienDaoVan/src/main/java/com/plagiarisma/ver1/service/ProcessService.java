package com.plagiarisma.ver1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plagiarisma.ver1.until.ProcessString;

@Service
public class ProcessService {
	//xu ly du lieu dau vao 
	public List<ProcessString> processStringInput(String stringInput){
		if(stringInput.isEmpty())
			return null;
//		HashMap<String, Integer> hits = new HashMap<String, Integer>();
//		
//		try {
//			hits =Uniti.getFrequency(stringInput);
//		} catch (IOException e) {}
//		List<ProcessString> ls = null;
//		for (String key : hits.keySet()) {
//			ProcessString curr=new ProcessString();
//			curr.setWord(key);
//			curr.setFrequency(hits.get(key));
//			ls.add(curr);
//		}
		List<ProcessString> ls = null;
//		VietTokenizer token = new VietTokenizer();
//		String[] sentences = token.tokenize(stringInput);
		// Xóa các kí tự thừa
//		String str = null;
//		try {
//			str = Uniti.HanglingText(sentences[0]);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// cắt các từ dựa vào khoảng trắng
		String[] words = stringInput.split("\\s");
		// Duyệt các từ ở mảng
		for (String word : words) {
			ProcessString cr=new ProcessString();
			cr.setWord(word);
			cr.setFrequency(1);
			ls.add(cr);
		}
		if(ls.isEmpty())
			return null;
		return ls;
	}
}
