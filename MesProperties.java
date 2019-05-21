import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

	public class MesProperties {
	//ma merhode avec le parametre le fichier a utiliser
		
		private static Properties properties;
		private static MesProperties myprop= null;
		
		

		public static MesProperties getInstance(String file) throws FileNotFoundException, IOException {
		if (myprop==null)
			myprop=new MesProperties(file);
		return myprop;
		}
		
		 public MesProperties(String file) throws IOException, FileNotFoundException{
		      properties = new Properties();

		      InputStream input = new FileInputStream(file); 
		      try{

		         properties.load(input);   
		      }
		       finally{
		    	   input.close();
		    	   }

		   }
		
		 
		public static String ReadProperties(String cle) {
			
			Properties prop = new Properties();
			InputStream input1 = null;
			InputStream input2 = null;
			String result ="";
		 
			try {
		 
				String filename1 = "message-en.properties";
				String filename2 = "message-fr.properties";
				
				input1 = MesProperties.class.getClassLoader().getResourceAsStream(filename1);
				if (input1 == null) {
					System.out.println("Sorry, unable to find " + filename1);
				}
				prop.load(input1);
				
				input2=MesProperties.class.getClassLoader().getResourceAsStream(filename2)	;		
				if (input2 == null) {
					System.out.println("Sorry, unable to find " + filename2);
				}
				prop.load(input1);
		 
				String msg1=prop.getProperty("FIRST_DIGIT");
				String msg2=prop.getProperty("SECOND_DIGIT");
				String msg3=prop.getProperty("THIRD_DIGIT");
				
				result = "Company List = " + msg1 + ", " + msg2 + ", " + msg3;
		
		 
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input1 != null) {
					try {
						input1.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (input2 != null) {
					try {
						input2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return result;

		}
		
	}