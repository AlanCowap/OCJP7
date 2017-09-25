/**
 * Simple interface, used in demonstration of implementing methods with similar names from different interfaces.
 * 
 * @author Alan Cowap
 *
 */

package com.alancowap.ocjp7.exceptions;

import java.io.IOException;

public interface Writable {

	public abstract void open() throws IOException;
}
