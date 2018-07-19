package lotto;

import java.util.Random;

public class BusinessLogic {

	Random random = new Random();
	private String outputLotteryNum;
	
	
	
	public void setOutputLotteryNum(String outputLotteryNum) {
		this.outputLotteryNum = outputLotteryNum;
	}
	
	public String getOutputLotteryNum() {
		return outputLotteryNum;
	}

	public void makeLotteryNum() {
		int first  = random.nextInt(45)+1;
		int second = random.nextInt(45)+1;
		int third = random.nextInt(45)+1;
		int forth = random.nextInt(45)+1;
		int fifth = random.nextInt(45)+1;
		int sixth = random.nextInt(45)+1;
		boolean flag = true;
		
		int[] numArray = new int[46];
		numArray[first] += 1;
		numArray[second] += 1;
		numArray[third] += 1;
		numArray[forth] += 1;
		numArray[fifth] += 1;
		numArray[sixth] += 1;
		for(int i=0; i<numArray.length; i++) { // 중복 처리
			
			if(numArray[i] > 1) {
				flag = false;
				break;
			}
		}
		
		
		if(flag == true) {
			outputLotteryNum = "["+ first + "] " 
					+ "[" + second + "] " 
					+ "[" + third + "] " 
					+ "[" + forth + "] " 
					+ "[" + fifth + "] " 
					+ "[" + sixth + "]" ;
			
			setOutputLotteryNum(outputLotteryNum);
		}else {
			makeLotteryNum();
		}
		
	}
	
	

}
