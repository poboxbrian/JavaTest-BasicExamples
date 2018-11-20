/*
Two service-related interfaces are needed.  One specifies the form of an action, and the other specifies the form of the provider of that action.
This is the action-provider
*/
package userfuncs.binaryfuncs;

import userfuncs.binaryfuncs.BinaryFunc;

public interface BinFuncProvider {
    // Obtain a BinaryFunc
    public BinaryFunc get();
}
