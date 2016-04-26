package com.excilys.cdb.model;

import java.time.LocalDate;

public class Computer {

    private Long id;
    private String name;
    private LocalDate introduced;
    private LocalDate discontinued;
    private Company company;

    /**
     * default constructor for a computer.
     */
    public Computer() {
        id = 0L;
        name = "";
        introduced = null;
        discontinued = null;
        company = new Company();
    }

    /**
     * constructor for a computer.
     *
     * @param id
     *            id
     * @param name
     *            name
     * @param introduced
     *            introduced date
     * @param discontinued
     *            discontinued date
     * @param company
     *            company (with id = 0 if no company)
     */
    public Computer(final Long id, final String name, final LocalDate introduced, final LocalDate discontinued,
            final Company company) {
        this.id = id;
        this.name = name;
        this.introduced = introduced;
        this.discontinued = discontinued;
        this.company = company;
    }

    /**
     * Builder pattern for a computer.
     *
     * @author excilys
     */
    public static class ComputerBuilder {
        private Long id = 0L;
        private String name = "";
        private LocalDate introduced = null;
        private LocalDate discontinued = null;
        private Company company = new Company();

        /**
         *
         */
        public ComputerBuilder() {

        }

        /**
         *
         * @param id
         * @return
         */
        public ComputerBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        /**
         *
         * @param name
         * @return
         */
        public ComputerBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         *
         * @param introduced
         * @return
         */
        public ComputerBuilder introduced(final LocalDate introduced) {
            this.introduced = introduced;
            return this;
        }

        /**
         *
         * @param discontinued
         * @return
         */
        public ComputerBuilder discontinued(final LocalDate discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        /**
         *
         * @param company
         * @return
         */
        public ComputerBuilder company(final Company company) {
            this.company = company;
            return this;
        }

        /**
         *
         * @return
         */
        public Computer build() {
            return new Computer(id, name, introduced, discontinued, company);
        }
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public LocalDate getIntroduced() {
        return introduced;
    }

    /**
     *
     * @param introduced
     */
    public void setIntroduced(final LocalDate introduced) {
        this.introduced = introduced;
    }

    /**
     *
     * @return
     */
    public LocalDate getDiscontinued() {
        return discontinued;
    }

    /**
     *
     * @param discontinued
     */
    public void setDiscontinued(final LocalDate discontinued) {
        this.discontinued = discontinued;
    }

    /**
     *
     * @return
     */
    public Company getCompany() {
        return company;
    }

    /**
     *
     * @param company
     */
    public void setCompany(final Company company) {
        this.company = company;
    }

    /**
     *
     */
    @Override
    public String toString() {

        final String intro = introduced == null ? "null" : introduced.toString();
        final String discon = discontinued == null ? "null" : discontinued.toString();

        return id + " " + name + " " + intro + " " + discon + " " + company.toString();
    }

    /**
     * auto-generated hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((company == null) ? 0 : company.hashCode());
        result = (prime * result) + ((discontinued == null) ? 0 : discontinued.hashCode());
        result = (prime * result) + ((id == null) ? 0 : id.hashCode());
        result = (prime * result) + ((introduced == null) ? 0 : introduced.hashCode());
        result = (prime * result) + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * auto-generated equals
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Computer other = (Computer) obj;
        if (company == null) {
            if (other.company != null) {
                return false;
            }
        } else if (!company.equals(other.company)) {
            return false;
        }
        if (discontinued == null) {
            if (other.discontinued != null) {
                return false;
            }
        } else if (!discontinued.equals(other.discontinued)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (introduced == null) {
            if (other.introduced != null) {
                return false;
            }
        } else if (!introduced.equals(other.introduced)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
