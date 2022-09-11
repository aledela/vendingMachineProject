package vend;

/** Switch -- a two-position switch

@author  John David Stone<br />
Department of Computer Science<br />
Grinnell College<br />
<tt>reseda@grinnell.edu</tt>

@version June 26, 2018
**No changes were made in order to use the class in this package**

An object of the <code>Switch</code> class
models a conventional two-position toggle switch,
like the power switch on a vacuum cleaner.
*/

public class Switch {

/** The <code>on</code> field
    stores the current position of the switch
    (true for the "on" position, false for "off").
*/

private boolean on;

/** The <code>Switch</code> constructor
    allocates storage for a new <code>Switch</code>,
    initializes its current state to "off,"
    and returns it.
*/

Switch() {
    on = false;
}

/**
   The <code>report</code> method
   returns the current state of the switch.

   @return  the current state of the switch
            (true for "on", false for "off")
*/

public boolean report() {
    return on;
}

/** The <code>turn</code> method
    imposes a specified state on the switch.

    @param  newState  the state to be imposed
                      (true for "on", false for "off")
*/

public void turn(boolean newState) {
    on = newState;
}

/** The <code>toggle</code> method
    models the operation of toggling the switch,
    changing its state.
*/

public void toggle() {
    on = !on;
}

public boolean sameState(Switch input) {

    if (on == input.on) {
        return true;
    }
    else {
        return false;
    }
}

}

/* Copyright © 2008, 2018 John David Stone */

/* This program is free software.
You may redistribute it and/or modify it
under the terms of the GNU General Public License
as published by the Free Software Foundation --
either version 3 of the License
or (at your option) any later version.
A copy of the GNU General Public License
is available on the World Wide Web
at https://www.gnu.org/licenses/gpl.html.

This program is distributed
in the hope that it will be useful,
but WITHOUT ANY WARRANTY --
without even the implied warranty
of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
See the GNU General Public License for more details.
*/
