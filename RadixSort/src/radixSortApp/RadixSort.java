package radixSortApp;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {


    public static void radixSort(int []arr)
    {
        List<String> strArr = new ArrayList<String>();

        strArr=StringUtil.intToStr(arr);                        //  1 - Obtengo la lista de Strings a partir del arreglo de enteros
        int tamOffset=StringUtil.getMaxOff(strArr);             //    - Obtengo el valor de digitos del int(Str) mas grande
        int offset=tamOffset-1;
        strArr=StringUtil.zeroPaddingLeft(tamOffset,strArr);    //  2 - Llamo a la funcion zeroPaddingLeft para llenar con ceros
        int tracking;

        System.out.println("lista desordenada = " + strArr);

        List<String>[] lista = new ArrayList[10];                //  3 - Creo una lista de 10 elementos

        for (int i=0;i<lista.length;i++)                 //      inicializo la lista con 10 elementos List
            {
                lista[i] = new ArrayList<String>();
                lista[i].clear();
            }
        
        for (int k=0;k<tamOffset;k++)
        {
            //System.out.println("strArr = " + strArr);
            while (strArr.size()!=0)
            {
                //System.out.println("strArr = " + strArr);
                //System.out.println(strArr.get(0).charAt(offset));
                tracking=Character.getNumericValue(strArr.get(0).charAt(offset));
                lista[tracking].add(strArr.get(0));//listas[tracking].get(0)+strArr.get(0)
                //System.out.println("tracking = " + tracking);
                strArr.remove(0);
                //System.out.println("lista [" +tracking+"]="+ lista[tracking]);
            }

            for (int i=0;i<lista.length;i++)
            {
                if (lista[i].isEmpty()!=true)
                {
                    for (int j=0;j<lista[i].size();j++)
                    {
                        strArr.add(lista[i].get(j));
                    }
                }
                lista[i].clear();                           //Limpio las listas para la proxima ejecucion
            }
            offset=offset-1;
        }
        System.out.println("Lista ordenada = " + strArr);
    }

    public static void main(String[] args) {

        System.out.println("Programa de ordenamiento con metodo RadixSort");
        int arr[]={16223,989,13,906,23544,23,9,1532,6388,2511,8};
        //int arr[]={3,673,106,45,2,23};
        radixSort(arr);

    }
}
