package io.quarkus.gizmo2.impl.constant;

import java.lang.constant.ConstantDesc;
import java.lang.constant.DynamicConstantDesc;
import java.util.Optional;

import io.github.dmlloyd.classfile.CodeBuilder;
import io.quarkus.gizmo2.impl.BlockCreatorImpl;

public final class DynamicConstant extends ConstantImpl {

    private final DynamicConstantDesc<?> desc;

    public DynamicConstant(final DynamicConstantDesc<?> desc) {
        super(desc.constantType());
        this.desc = desc;
    }

    public DynamicConstant(final ConstantDesc constantDesc) {
        this((DynamicConstantDesc<?>) constantDesc);
    }

    public boolean equals(final ConstantImpl obj) {
        return obj instanceof DynamicConstant other && equals(other);
    }

    public boolean equals(final DynamicConstant other) {
        return this == other || other != null && desc.equals(other.desc);
    }

    public int hashCode() {
        return desc.hashCode();
    }

    public DynamicConstantDesc<?> desc() {
        return desc;
    }

    public void writeCode(final CodeBuilder cb, final BlockCreatorImpl block) {
        cb.ldc(desc());
    }

    public Optional<? extends ConstantDesc> describeConstable() {
        return Optional.of(desc);
    }
}
