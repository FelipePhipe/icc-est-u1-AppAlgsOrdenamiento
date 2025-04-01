class MetodoSeleccionFP {
    public void ordenar(int[] arreglo, boolean ascendente, boolean conPasos) {
        int comparaciones = 0;
        int cambios = 0;
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            int extremo = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                comparaciones++;
                boolean debeSeleccionar = ascendente ? arreglo[j] < arreglo[extremo] : arreglo[j] > arreglo[extremo];
                
                if (conPasos) {
                    System.out.println("Comparación " + (comparaciones) + ": " + arreglo[j] + 
                            (ascendente ? " < " : " > ") + arreglo[extremo]);
                }
                
                if (debeSeleccionar) {
                    extremo = j;
                }
            }
            
            if (extremo != i) {
                cambios++;
                if (conPasos) {
                    System.out.println("Intercambio: " + arreglo[i] + " <-> " + arreglo[extremo]);
                }
                int temp = arreglo[i];
                arreglo[i] = arreglo[extremo];
                arreglo[extremo] = temp;
                
                if (conPasos) {
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