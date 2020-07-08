package design.solution;

import java.util.function.Predicate;

public enum Catagory {
    ALL {
        @Override
        public Predicate<User> userPredicate() {
            return user -> true;
        }
    },
    CHILD {
        @Override
        public Predicate<User> userPredicate() {
            return user -> !(user.getAge() >= 18);
        }
    },
    ADULT {
        @Override
        public Predicate<User> userPredicate() {
            return user -> user.getAge() >= 18;
        }
    },
    ELDER {
        @Override
        public Predicate<User> userPredicate() {
            return user -> user.getAge() > 45;
        }
    };

    public abstract Predicate<User> userPredicate();

}
