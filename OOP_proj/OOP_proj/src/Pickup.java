import java.util.Scanner;

public class Pickup {
	static Scanner scanner = new Scanner(System.in);
	static int isPackaging = -1; // 포장 혹은 매장 선택 변수
	
	// 포장&매장 선택
	public static void TakeoutStatus() {
		String answer;
		while(true) {
			System.out.println("[키오스크] 포장과 매장 중 이용 방법을 선택해주세요.");
			System.out.print(">>");
			answer = scanner.nextLine();
			System.out.println("");
			
			if(answer.matches(".*(포장|가져)+.*")) {
				isPackaging = 0;
				break;
			}
			else if(answer.matches(".*(매장|먹고)+.*")) {
				isPackaging = 1;
				break;
			}
		}
	}
	
	// 대기 후 음식 픽업 함수
	public static void FoodPickup() {
		int maxWaitingTime = 0;
		
	    for (MenuList.MenuItem menuItem : MenuList.hamburgers) {
	        if (menuItem.time > maxWaitingTime) {
	            maxWaitingTime = menuItem.time;
	        }
	    }
	    for (MenuList.MenuItem menuItem : MenuList.desserts) {
	        if (menuItem.time > maxWaitingTime) {
	            maxWaitingTime = menuItem.time;
	        }
	    }
	    for (MenuList.MenuItem menuItem : MenuList.beverages) {
	        if (menuItem.time > maxWaitingTime) {
	            maxWaitingTime = menuItem.time;
	        }
	    }
	    
	    if (maxWaitingTime > 300) {
	        maxWaitingTime = 300;
	    }
        
    
    	System.out.println("[system] 음식을 준비하고 있습니다... (예상 대기 시간 " + maxWaitingTime/60 + "분 " + maxWaitingTime%60 + "초)");
    	
    	while (maxWaitingTime > 0) {
            System.out.println(">> 남은 시간 | " + maxWaitingTime/60 + "분 " + maxWaitingTime%60 + "초");
            Function.timer();
            maxWaitingTime = maxWaitingTime - 30;
        }

        System.out.println("[system] 주문번호 "+Payment.random+"번 손님! 음식이 준비되었습니다.");
        Function.timer(2);
        
        System.out.println("[system] 픽업 완료!");
        Function.timer(2);
        if(isPackaging == 0) {
        	System.out.println("[system] 음식을 맛있게 먹고 트레이는 제자리에 가져다 놓았다!");
        }
        else if(isPackaging == 1) {
        	System.out.println("[system] 포장된 음식을 가져가 맛있게 먹었다!");
        }
        
        Function.timer();
	}
}