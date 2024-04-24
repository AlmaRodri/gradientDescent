import jade.core.Agent;


public class SimpleAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
      addBehaviour(new MyOneShotBehaviour());}
    //Add OneshotBehaviour
     private class MyOneShotBehaviour extends jade.core.behaviours.OneShotBehaviour {
          public void action() {
            double pre;
            DataSet dataSet = new DataSet(); // Inicializa el objeto DataSet
               double[] x = dataSet.getX();
              double[] y = dataSet.getY();
              GradientDescent gradienteD = new GradientDescent(0.0007);
            gradienteD.gradiente(x, y, 90000);
            gradienteD.printRegEquation(); //imprime la ecuacion de regresion
            System.out.println("Coeficiente de correlacion: " + Correlations.correlaCoef(dataSet));
            System.out.println("Coeficiente de determinacion: " + Correlations.correlaDetermina(dataSet));
              pre = 30;
            System.out.println("La prediccion de "+ pre + " es: " + gradienteD.predict(pre));
              pre = 31;
            System.out.println("La prediccion de "+ pre + " es: " + gradienteD.predict(pre));
              pre = 32;
            System.out.println("La prediccion de "+ pre + " es: " + gradienteD.predict(pre));
          }
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

    }

}
