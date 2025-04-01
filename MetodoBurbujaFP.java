class MetodoBurbujaFP {
    public void ordenar(int[] arreglo, boolean ascendente, boolean conPasos) {
        int comparaciones = 0;
        int cambios = 0;
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                comparaciones++;
                boolean debeIntercambiar = ascendente ? arreglo[j] > arreglo[j + 1] : arreglo[j] < arreglo[j + 1];
                
                if (conPasos) {
                    System.out.println("Comparación " + (comparaciones) + ": " + arreglo[j] + 
                            (ascendente ? " > " : " < ") + arreglo[j + 1]);
                }
                
                if (debeIntercambiar) {
                    cambios++;
                    if (conPasos) {
                        System.out.println("Intercambio: " + arreglo[j] + " <-> " + arreglo[j + 1]);
                    }
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    
                    if (conPasos) {
                        System.out.println("Estado actual -> " + App.arrayToString(arreglo));
                    }
                } else if (conPasos) {
                    System.out.println("(No hay intercambio)");
                    System.out.println("Estado actual -> " + App.arrayToString(arreglo));
                }
            }
        }
        
        if (!conPasos) {
            System.out.println("Comparaciones Totales -> " + comparaciones);
            System.out.println("Cambios Totales -> " + cambios);
        }
    }
}