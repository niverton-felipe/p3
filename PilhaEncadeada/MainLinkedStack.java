package p3.PilhaEncadeada;

public class MainLinkedStack {
    public static void main(String[] args) {
        PilhaEncadeada stack = new PilhaEncadeada();
        stack.push(new Elemento());
        stack.push(new Elemento());
        stack.push(new Elemento());
        stack.push(new Elemento());
        stack.push(new Elemento());
        System.out.println(stack.sizeRecursivo(stack.peek()));
        stack.clearRecursivo();
        System.out.println(stack.sizeRecursivo(stack.peek()));
    }
}
