package radixSortApp;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static List<String> intToStr(int []arr)  //Esta funcion me devuelve el arreglo en String
    {
        List<String> strArrInt = new ArrayList<String>();  // Lista para convertir los enteros del array int
        for (int i=0;i< arr.length;i++)
        {
            strArrInt.add(String.valueOf(arr[i]));
        }
        return strArrInt;
    }
    public static int getMaxOff(List<String> listData )
    {
        int longest=listData.get(0).length();
        for(int i=0;i< listData.size();i++)
        {
            if(longest<=listData.get(i).length())
            {
                longest=listData.get(i).length();
            }
        }
        return longest;
    }
    public static List<String> zeroPaddingLeft(int tamOff, List<String> listData )
    {
        int zeros=0;
        String strVal;
        String newVal;

        for (int i=0;i<listData.size();i++)
        {
            if(listData.get(i).length()<tamOff)
            {
                zeros=tamOff-listData.get(i).length();
                strVal=listData.get(i);
                for (int j=0;j<zeros;j++)
                {
                    newVal="0"+strVal;
                    strVal=newVal;
                }
                listData.set(i,strVal);       //con el metodo set reemplazo el valor segun el indice en una lista
            }
        }
        return listData;
    }
}
