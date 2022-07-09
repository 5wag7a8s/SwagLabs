import java.util.*;

public class DisplayCalendar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter year: ");
		int year = input.nextInt();
		System.out.print("Enter first day of the year(0-6):  ");
		int day = input.nextInt();
		for (int k = 1; k <= 12; k++) {
			String month = "";
			int numOfDays = 0;
			switch (k) {
			case 1:
				month = "January ";
				numOfDays = 31;
				break;
			case 2:
				month = "February ";
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
					numOfDays = 29;
				else
					numOfDays = 28;
				break;
			case 3:
				month = "March ";
				numOfDays = 31;
				break;
			case 4:
				month = "April ";
				numOfDays = 30;
				break;
			case 5:
				month = "May ";
				numOfDays = 31;
				break;
			case 6:
				month = "June ";
				numOfDays = 30;
				break;
			case 7:
				month = "July ";
				numOfDays = 31;
				break;
			case 8:
				month = "August ";
				numOfDays = 31;
				break;
			case 9:
				month = "September ";
				numOfDays = 30;
				break;
			case 10:
				month = "October ";
				numOfDays = 31;
				break;
			case 11:
				month = "November ";
				numOfDays = 30;
				break;
			case 12:
				month = "December ";
				numOfDays = 31;
				break;
			}
			System.out.println(month + year);
			System.out.println("Sun   Mon   Tue   Wed   Thu   Fri   Sat");
			for (int i = 1; i <= day; i++)
				System.out.print("      ");
			for (int j = 1; j <= numOfDays; j++) {
				if (day % 7 == 0 && day != 0)
					System.out.println();
				System.out.printf("%3d   ", j);
				day += 1;
			}
			day %= 7;
			System.out.print("\n\n");
		}
		input.close();
	}
}