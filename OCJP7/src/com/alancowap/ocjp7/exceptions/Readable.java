/**
 * Simple interface, used in demonstration of implementing methods with similar names from different interfaces.
 * 
 * @author Alan Cowap
 *
 */

package com.alancowap.ocjp7.exceptions;

import java.sql.SQLException;

public interface Readable {

	public abstract void open() throws SQLException;
}
