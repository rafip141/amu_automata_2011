package pl.edu.amu.wmi.daut.re;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ConvertRegexpOperatorTreeIntoRegexp {

    public ConvertRegexpOperatorTreeIntoRegexp(RegexpOperatorManager man, RegexpOperatorTree tre) {
        manager = man;
        tree = tre;
        allOperatorIds.addAll(manager.getAllOperatorIds());
    }

    public String convert() {
        List<RegexpOperatorTree> tempTree = new ArrayList<RegexpOperatorTree>();
        RegexpOperator tempOperator;
        tempOperator = tree.getRoot();
        String str = new String();
        List<String> listOfSeparators = new ArrayList<String>();
        List<String> listOfParams = new ArrayList<String>();

        for (String id : allOperatorIds) {
            if(tempOperator.getFactory().getClass().equals(manager.getFactory(id).getClass())) {

                listOfSeparators.addAll(manager.getSeparators(id));
                listOfParams.addAll(tempOperator.getParams());

                String temp = new String();
                for (String st : listOfSeparators) {
                    if(!(st.toString() == "")) {
                        temp.concat(st + listOfParams.remove(0));
                    }
                }
            }
        }



        return str;
    }

    RegexpOperatorManager manager = new RegexpOperatorManager();
    List<String> allOperatorIds = new ArrayList<String>();
    RegexpOperatorTree tree;
}
