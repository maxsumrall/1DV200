import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Jonathan Sumrall, Ryan Lengel
 * 1DV200
 * LNU - Spring 2012
 * Practical Assignment 1
 * 
 * 
 *This is a small program that have various encryption algorithms implemented.
 *Users should be presented with the option to specific the name of a text file to 
 *encrypt and then choose an encryption method, and to then have a new file generated
 *that is an encrpyted version of the original. 
 *I guess it would also be able to apply the decryption of a file using 
 *a specified algorithm.  
 */

public class encryptor{

	public static void main(String [] args) throws IOException{
		String encryptionMethod = "";
		String fileName = "";
		String key = "";
		boolean encrypt = false;
		BufferedReader reader = null;
		
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		//kb, as in "keyboard"
		System.out.println("Hej Hej");
		System.out.println("Choose a method:\n (1)Caesar-Cipher \n(2)Max-Cipher \n(3)Transposition Method");
		encryptionMethod = kb.readLine();
		System.out.print("Choose the operation you want to do: Encryption (1), Decryption (2): ");
		String operation = kb.readLine();
		if(operation.equals("1")){encrypt = true;}
		System.out.print("Type the name of the file [MUST BE IN SAME DIRECTORY] :");
		fileName = kb.readLine();
		System.out.print("Type the key you want to use (If applicable, otherwise press enter): ");
		key = kb.readLine();
		try{
			reader = new BufferedReader(new FileReader(fileName));
		}
		catch(IOException e){
			System.out.println("Falied to open the file you wanted to encrypt");
		}
		//=================================
		if (encryptionMethod.equals("1")){
			System.out.print("Attempting Caesar Method. ");
			CaesarCipher cipher = new CaesarCipher();
			if(encrypt){
				if(cipher.encrypt(reader,"Encrypted"+fileName)){System.out.println("Success");}
			}
			else{
				if(cipher.decrypt(reader,"Decrypted"+fileName)){System.out.println("Success");}
			}
				
		}
		
		if (encryptionMethod.equals("2")){
			System.out.println("Attempting Max Method. ");
			MaxCipher max = new MaxCipher(key);
			if(encrypt){
				if(max.encrypt(reader,"Encrypted"+fileName)){System.out.println("Success");}
			}
			else{
				if(max.decrypt(reader, "Decrypted"+ fileName)){System.out.println("Success");}
			}	
		}
		
		if(encryptionMethod.equals("3")){
			System.out.println("Attemping Transposition Method");
			Transposition t = new Transposition();
			Integer i = new Integer(key);
			if(encrypt){
				if(t.encodeColumnarTransposition(reader,"Encrypted"+fileName, i)){System.out.println("Success");}
			}
			else{
				if(t.decodeColumnarTransposition(reader, "Decrypted"+fileName, i)){System.out.println("Success");}
			}	
			
		}
	}
}
	
	




