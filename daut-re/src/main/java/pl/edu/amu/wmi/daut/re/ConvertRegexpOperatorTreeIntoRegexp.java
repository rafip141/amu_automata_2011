package pl.edu.amu.wmi.daut.re;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ConvertRegexpOperatorTreeIntoRegexp {

    public ConvertRegexpOperatorTreeIntoRegexp(RegexpOperatorManager man) {
        manager = man;
        allOperatorIds.addAll(manager.getAllOperatorIds());
    }

    public String convert(RegexpOperatorTree tree) {
        StringBuffer buffer = new StringBuffer();

        doConvert(buffer, tree);

        return buffer.toString();
    }

    private void doConvert(StringBuffer buffer, RegexpOperatorTree tree) {

        switch(tree.getRoot().arity()) {
            case 0:
                write(buffer, tree);
                break;
            case 1:
                doConvert(buffer, tree.getSubtrees().get(0));
                write(buffer, tree);
                break;
            case 2:
                doConvert(buffer, tree.getSubtrees().get(0));
                write(buffer, tree);
                doConvert(buffer, tree.getSubtrees().get(1));
                break;
        }
    }

    private void write(StringBuffer buffer, RegexpOperatorTree tree) {
        RegexpOperator tempOperator;
        tempOperator = tree.getRoot();

        List<String> listOfSeparators = new ArrayList<String>();
        List<String> listOfParams = new ArrayList<String>();

        for (String id : allOperatorIds) {
            if(tempOperator.getFactory().getClass().equals(manager.getFactory(id).getClass())) {

                listOfSeparators.addAll(manager.getSeparators(id));
                listOfParams.addAll(tempOperator.getParams());

                for (String sep : listOfSeparators) {
                    if (!listOfParams.isEmpty()) {
                        buffer.append(sep + listOfParams.remove(0));
                    } else {
                        buffer.append(sep);
                    }
                }
                break;
            }
        }
    }

    RegexpOperatorManager manager = new RegexpOperatorManager();
    List<String> allOperatorIds = new ArrayList<String>();
}
