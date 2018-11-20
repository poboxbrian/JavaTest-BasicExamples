/*
Two service-related interfaces are needed.  One specifies the form of an action, and the other specifies the form of the provider of that action.
This is the action
*/
package userfuncs.binaryfuncs;

public interface BinaryFunc {
    //obtain name of the function
    public String getName();

    // This is the function to perform and will be 
    // provided by specific implementations
    public int func(int a, int b);
}
