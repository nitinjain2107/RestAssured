package AutomationAPI.RestAssured;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class JsonContentCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath jp=new JsonPath(Payload.CoursePrice());
		String var="";
		int sum=0;
		
		int c=jp.getInt("courses.size()");
		System.out.println(c);
		int pa=jp.getInt("dashboard.purchaseAmount");
//		for (int i=0;i<c;i++)
//		{
//			if()
//			System.out.println(jp.getString("courses["+i+"].title"));
//			System.out.println(jp.getString("courses["+i+"].price"));
//		}
//		for (int i=0;i<c;i++)
//		{
//			var=jp.getString("courses["+i+"].title");
//			if(var.equalsIgnoreCase("RPA")) {
//			System.out.println(jp.getString("courses["+i+"].copies"));
//			break;
//			}
			for (int i=0;i<c;i++)
			{
				sum=sum+(jp.getInt("courses["+i+"].price")*jp.getInt("courses["+i+"].copies"));

				
				}
			if(pa==sum) {
			System.out.println("values are same "+sum);
			}
			else
			{
				System.out.println("values are not same"+sum+"and"+pa);
			}
			
		}


}
