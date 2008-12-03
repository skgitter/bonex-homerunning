package example;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class MenuAction {
    private String menuString;
   
    private List<Menu> menus;
   
    public String execute() {

        menus = new ArrayList<Menu>();
       
        Menu benz = new Menu();
        benz.setText("Benz");
        benz.setCls("folder");
        benz.setLeaf(false);
        benz.setId(10);
        menus.add(benz);
       
        List<Menu> benzList = new ArrayList<Menu>();
        benz.setChildren(benzList);
       
        Menu menu;
        menu = new Menu();
        menu.setText("S600");
        menu.setCls("file");
        menu.setLeaf(true);
        menu.setId(11);
        benzList.add(menu);
        menu = new Menu();
        menu.setText("SLK200");
        menu.setCls("file");
        menu.setLeaf(true);
        menu.setId(12);
        benzList.add(menu);
       
        Menu bmw = new Menu();
        bmw.setText("BMW");
        bmw.setCls("folder");
        bmw.setLeaf(false);
        bmw.setId(20);
        menus.add(bmw);
       
        List<Menu> bmwList = new ArrayList<Menu>();
        bmw.setChildren(bmwList);
       
        menu = new Menu();
        menu.setText("325i");
        menu.setCls("file");
        menu.setLeaf(true);
        menu.setId(21);
        bmwList.add(menu);
       
        menu = new Menu();
        menu.setText("X5");
        menu.setCls("file");
        menu.setLeaf(true);
        menu.setId(22);
        bmwList.add(menu);
       
        JSONArray jsonObject = JSONArray.fromObject(menus);
        try {
            menuString = jsonObject.toString();
        } catch (Exception e) {
            menuString = "ss";
        }

        return "success";
    }

    public String getMenuString() {
        return menuString;
    }

    public void setMenuString(String menuString) {
        this.menuString = menuString;
    }
}
