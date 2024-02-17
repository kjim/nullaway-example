package org.example;

public final class NullableWithLombok {

    public void jsr305() {
        new JSR305NullableValue(null);
    }

    public void jakartaAnnotation() {
        new JakartaAnnotationNullableValue(null);
    }

    public void jetbrains() {
        new JetbrainsNullableValue(null);
    }

    public void checkerframework() {
        new CheckerframeworkNullableValue(null);
    }

    public void jspecify() {
        new JSpecifyNullableValue(null);
    }

    @lombok.Value
    private static class JSR305NullableValue {
        @javax.annotation.Nullable
        Object value;
    }

    @lombok.Value
    private static class JakartaAnnotationNullableValue {
        @jakarta.annotation.Nullable
        Object value;
    }

    @lombok.Value
    private static class JetbrainsNullableValue {
        @org.jetbrains.annotations.Nullable
        Object value;
    }

    @lombok.Value
    private static class CheckerframeworkNullableValue {
        @org.checkerframework.checker.nullness.qual.Nullable
        Object value;
    }

    @lombok.Value
    private static class JSpecifyNullableValue {
        @org.jspecify.annotations.Nullable
        Object value;
    }
}
