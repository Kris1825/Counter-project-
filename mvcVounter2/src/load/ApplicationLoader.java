package load;

import controler.CounterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import model.Counter;
import model.ModuloCounter;
import view.CounterPane;

public class ApplicationLoader extends Application {

	private Accordion root;

	@Override
	/* Build the scene graph in this method */
	public void init() throws Exception {
		
		/* --APPROACH 1--
		 * Each view is passed a reference to the model and also
		 * contains the (event handling) controller internally.
		 */
		//Counter model1 = new Counter(); 
		CounterPane view1 = new CounterPane();
		Counter c = new Counter() ;
		new CounterController(view1, c);
		//Counter model2 = new ModuloCounter(5); 
		CounterPane view2 = new CounterPane();
		ModuloCounter mc = new ModuloCounter(5);
		new CounterController(view2,mc);
		root = new Accordion(); 
		root.getPanes().addAll(new TitledPane("Counter", view1), new TitledPane("modulo" , view2));
		//root.setExpandedPane(root.getPanes().get(0));

		
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(root);
		stage.setTitle("Counter");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

