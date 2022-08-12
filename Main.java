class Main {
    static class students {
        public int age;
        public String name;

        students(int age, String name) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Node<students> studentsNode = new Node<>(new students(18, "alex"));
        Node<students> DBStudents = new Node<>(new students(20, "si"));
        studentsNode.add(new students(19, "kevin"));
        studentsNode.add(DBStudents);

        System.out.println(studentsNode.get(0).data.age);
        System.out.println(studentsNode.get(1).data.age);
        System.out.println(studentsNode.get(2).data.age);
        studentsNode.safeDelete(0);
        System.out.println(studentsNode.get(0).data.age);
        System.out.println(studentsNode.get(1).data.age);
        System.out.println(studentsNode.get(2).data.age);

    }
}