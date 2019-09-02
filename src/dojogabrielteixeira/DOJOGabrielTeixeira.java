
package dojogabrielteixeira;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DOJOGabrielTeixeira {

    public static void main(String[] args) throws FileNotFoundException, IOException {
	File file = new File(System.getProperty("user.dir")+"\\src\\dojogabrielteixeira\\jquery-3.4.1.js"); 
		 
	BufferedReader br = new BufferedReader(new FileReader(file)); 
		 
	String st;
        String full = "";
	while ((st = br.readLine()) != null) {
            String stTrim = st.trim();
            if(stTrim.startsWith("//")) continue;
            if(stTrim.contains("//")) {
                stTrim = stTrim.substring(0, stTrim.indexOf("//")-1);
            }
            full += stTrim;		 
	}

        full = full.replaceAll("\\/\\*[\\s\\S]*?\\*\\/|([^\\\\:]|^)\\/\\/.*|<!--[\\s\\S]*?-->$", "");
		 
	System.out.println(full);
        List<String> lines = Arrays.asList(full);
        Path fullFile = Paths.get(System.getProperty("user.dir")+"\\src\\dojogabrielteixeira\\minifiedJquery.js");
        Files.write(fullFile, lines, StandardCharsets.UTF_8);
    }
    
}
