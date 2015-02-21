package src;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;

/**
 * Class LayeredLayout - overrides LayoutManager methods to overlay components
 *
 * @author	Jennifer Cryan
 * @author 	Jessica Huang
 * @author 	Jazarie Thach
 * @author 	Felica Truong
 * @author 	Josephine Vo
 * @version for CS48, Winter 2015, UCSB
 */
public class LayeredLayout implements LayoutManager {
	private        final Container target;
    private static final Dimension preferredSize = new Dimension(500, 500);

    /**
     * Constructor LayeredLayout - creates layout with layers for target container
     */
    public LayeredLayout(final Container target) {
    	this.target = target;
    }

    /**
     * Override addLayoutComponent - sets name and component in layout
     *          @param             - name of component
     *          @param             - component to be added
     */
    @Override
    public void addLayoutComponent(final String name, final Component comp) {
    }

    /**
     * Override layoutContainer - sets component in container
     *          @param          - container to associate with component
     */
    @Override
    public void layoutContainer(final Container container) {
    	for (final Component component : container.getComponents()) {
    		component.setBounds(new Rectangle(0, 0, target.getWidth(), target.getHeight()));
    	}
    }

    /**
     * Override minimumLayoutSize - gets minimum layout size
     *          @param            - parent container
     *          @return           - minimum size of container
     */
    @Override
    public Dimension minimumLayoutSize(final Container parent) {
    	return preferredLayoutSize(parent);
    }

    /**
     * Override preferredLayoutSize - gets preferred layout size
     *          @param              - parent container
     *          @return             - preferred size of container
     */
    @Override
    public Dimension preferredLayoutSize(final Container parent) {
    	return preferredSize;
    }

    /**
     * Override removeLayoutComponent - removes layout component
     */
    @Override
    public void removeLayoutComponent(final Component comp) {
    }
}

