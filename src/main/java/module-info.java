module hm.branchproject.expenseapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens hm.branchproject.expenseapp to javafx.fxml;
    exports hm.branchproject.expenseapp;
}