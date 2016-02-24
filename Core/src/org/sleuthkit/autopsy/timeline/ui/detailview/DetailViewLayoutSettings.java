/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sleuthkit.autopsy.timeline.ui.detailview;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 */
public class DetailViewLayoutSettings {

    /**
     * true == truncate all the labels to the greater of the size of their
     * timespan indicator or the value of truncateWidth. false == don't truncate
     * the labels, alow them to extend past the timespan indicator and off the
     * edge of the screen
     */
    final SimpleBooleanProperty truncateAll = new SimpleBooleanProperty(false);
    /**
     * the width to truncate all labels to if truncateAll is true. adjustable
     * via slider if truncateAll is true
     */
    final SimpleDoubleProperty truncateWidth = new SimpleDoubleProperty(200.0);
    /**
     * true == layout each event type in its own band, false == mix all the
     * events together during layout
     */
    private final SimpleBooleanProperty bandByType = new SimpleBooleanProperty(false);

    /**
     * true == enforce that no two events can share the same 'row', leading to
     * sparser but possibly clearer layout. false == put unrelated events in the
     * same 'row', creating a denser more compact layout
     */
    private final SimpleBooleanProperty oneEventPerRow = new SimpleBooleanProperty(false);

    /**
     * how much detail of the description to show in the ui
     */
    private final SimpleObjectProperty<DescriptionVisibility> descrVisibility =
            new SimpleObjectProperty<>(DescriptionVisibility.SHOWN);

    public synchronized SimpleBooleanProperty bandByTypeProperty() {
        return bandByType;
    }

    SimpleBooleanProperty oneEventPerRowProperty() {
        return oneEventPerRow;
    }

    SimpleDoubleProperty truncateWidthProperty() {
        return truncateWidth;
    }

    SimpleBooleanProperty truncateAllProperty() {
        return truncateAll;
    }

    SimpleObjectProperty< DescriptionVisibility> descrVisibilityProperty() {
        return descrVisibility;
    }

    synchronized void setBandByType(Boolean t1) {
        bandByType.set(t1);
    }

    boolean getBandByType() {
        return bandByType.get();
    }

    boolean getTruncateAll() {
        return truncateAll.get();
    }

    double getTruncateWidth() {
        return truncateWidth.get();
    }

    boolean getOneEventPerRow() {
        return oneEventPerRow.get();
    }

    DescriptionVisibility getDescrVisibility() {
        return descrVisibility.get();
    }
}
