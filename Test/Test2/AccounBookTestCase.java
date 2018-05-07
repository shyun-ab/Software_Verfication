import static org.junit.Assert.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class AccounBookTestCase {

   @Test
   public void testAccountWrite() throws IOException 
   {
      AccountWrite write = new AccountWrite();
      
      String write_item="solo cappuccino";
      write.fileWrite("2017/12/23", write_item, "4500");
      write.fileWrite("2017/12/24", "double cappuccino", "3800");
      write.fileWrite("2017/12/25", "cold cappuccino", "4000");
      write.fileWrite("2017/12/23", "hot cappuccino", "3000");
      
      String write_line_item;
      String get_write_line_item = null;
      
      BufferedReader item_br = new BufferedReader(new FileReader("accountItem.txt"));
      while((write_line_item=item_br.readLine()) != null)
      {
         get_write_line_item=write_line_item;
      }

      item_br.close();
      
   }
   
   @Test
   public void testAccounEdit() throws IOException 
   {

      new AccountMain();
      String edit_item="golden_cake";
      String before_edit="";
      String edit_line_item;

      System.out.println("edit item: "+edit_item);
      
      before_edit=Files.readAllLines(Paths.get("accountItem.txt")).get(2);
      System.out.println("before edit(line 3):"+before_edit);

      AccountEdit.editfile(2, "2021/12/15",edit_item , "500000");
   
      edit_line_item=Files.readAllLines(Paths.get("accountItem.txt")).get(2);

      System.out.println("edit line in txt: "+edit_line_item);
      
      if(edit_line_item.equals(edit_item))
      {
         System.out.println("true");
      }
      assertTrue(edit_line_item.equals(edit_item));

   }
   

}