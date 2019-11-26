/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_03;

/**
 *
 * @author Pedro
 */
public class ArrayStack<T> implements StackADT<T> {

    private final int DEFAULT_SIZE = 100;
    private int top;
    private T[] stack;

    public ArrayStack() {
        top = 0;
        stack = (T[]) (new Object[DEFAULT_SIZE]);

    }

    public ArrayStack(int initialSize) {
        top = 0;
        stack = (T[]) new Object[initialSize];

    }

    /**
     * Adds the specified element to the top of this stack, expanding the
     * capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it. Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop is attempted on empty stack
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return (top == 0);
    }

    @Override
    public int size() {
        return top - 1;
    }

    private void expandCapacity() {
        T[] expandedArray = (T[]) new Object[stack.length * 2];
        for (int x = 0; x < stack.length; x++) {
            expandedArray[x] = stack[x];
        }
        stack = expandedArray;
    }

    @Override
    public String toString() {
        {
            if (isEmpty()) {
                return "[ ]";
            }

            StringBuilder out = new StringBuilder("[");
            for (int i = 0; i < top; i++) 
                out.append(stack[i]).append(", ");
            

            out.append(stack[top]).append("]");
            return out.toString();
        }
    }

}
